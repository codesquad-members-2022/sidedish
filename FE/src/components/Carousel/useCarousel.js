import { useEffect, useState } from 'react';

const useCarousel = ({
  getSlideDataByPage,
  maxPage,
  buttonPrevCss,
  buttonNextCss,
}) => {
  const [slides, setSlides] = useState([]);
  const [cachedSlides, setCachedSlides] = useState([]);
  const [curPage, setCurPage] = useState(0);
  const [clickedButton, setClickedButton] = useState(null);
  const [transitioning, setTransitioning] = useState(false);

  const fetchNewPage = (page) => {
    const newNextSlide = getSlideDataByPage(page);
    setCachedSlides([...slides, newNextSlide]);
  };

  const onClickNext = () => {
    const newCurPage = curPage + 1;
    setCurPage(newCurPage);
    setTransitioning(true);
    setClickedButton('next');
  };

  const onClickPrev = () => {
    const newCurPage = curPage - 1;
    setCurPage(newCurPage);
    setTransitioning(true);
    setClickedButton('prev');
  };

  const onTransitionEnd = () => {
    setTransitioning(false);
  };

  useEffect(() => {
    const isNewPageRequest = cachedSlides.length < curPage + 1;
    if (isNewPageRequest) {
      fetchNewPage(curPage);
    }
  }, [curPage]);

  useEffect(() => {
    const isPageInit = clickedButton === null;
    const prevBtnRenderCond = clickedButton === 'prev' && !transitioning;
    const nextBtnRenderCond = clickedButton === 'next' && transitioning;
    if (isPageInit || prevBtnRenderCond || nextBtnRenderCond) {
      setSlides(cachedSlides.slice(0, curPage + 1));
    }
  }, [curPage, cachedSlides, transitioning]);

  return {
    slides,
    onClickPrev,
    onClickNext,
    onTransitionEnd,
    transitioning,
    maxPage,
    curPage,
    buttonPrevCss,
    buttonNextCss,
  };
};

export default useCarousel;
