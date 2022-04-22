import { useEffect, useState } from 'react';

const useCarousel = ({
  getSlideDataByPage,
  maxPage,
  buttonPrevCss,
  buttonNextCss,
}) => {
  const [slides, setSlides] = useState([]);
  const [curPage, setCurPage] = useState(0);

  const onClickNext = () => {
    const newCurPage = curPage + 1;
    setCurPage(newCurPage);
  };

  const onClickPrev = () => {
    const newCurPage = curPage - 1;
    setCurPage(newCurPage);
  };

  useEffect(() => {
    const isNewPageRequest = slides.length < curPage + 1;
    if (isNewPageRequest) {
      const newNextSlide = getSlideDataByPage(curPage);
      setSlides([...slides, newNextSlide]);
    }
  }, [curPage]);

  return {
    slides,
    onClickPrev,
    onClickNext,
    maxPage,
    curPage,
    buttonPrevCss,
    buttonNextCss,
  };
};

export default useCarousel;
