import React, {useState, useEffect} from 'react';
import {prevButtonIcon, nextButtonIcon} from 'constants';
import {SideDish} from 'components';

function Slider({data}) {
  const [sliderState, setSliderState] = useState({clickedButton: '', list: ''});
  const [position, setPosition] = useState(0);

  const handleClickedButton = ({target}) => {
    const current = target.closest('button').className;
    const listElement = target.closest('.event-slider').querySelector('.sideDishList');

    setSliderState({
      ...sliderState,
      clickedButton: current,
      list: listElement,
    });

    const goodBlockWidth = 326;
    setPosition(current === 'nextButton' ? position - goodBlockWidth : position + goodBlockWidth);
  };

  useEffect(() => {
    if (!sliderState.clickedButton) return;

    sliderState.list.style.transform = `translateX(${position}px)`;
    sliderState.list.style.transition = '0.2s ease-out';
  }, [sliderState, position]);

  return (
    <div className="event-slider">
      <button className="prevButton" onClick={handleClickedButton}>
        <img className="prevButtonIcon" src={prevButtonIcon} alt="prevButtonIcon"></img>
      </button>
      <button className="nextButton" onClick={handleClickedButton}>
        <img className="nextButtonIcon" src={nextButtonIcon} alt="nextButtonIcon"></img>
      </button>
      <div className="sideDishContainer">
        <ul className="sideDishList">
          <SideDish type="origin" data={data} />
        </ul>
      </div>
    </div>
  );
}

export {Slider};
