import React, {useState, useEffect} from 'react';
import {prevButtonIcon, nextButtonIcon} from '../constants/iconPath.js';
import {SideDish} from './SideDish.jsx';

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
  };

  useEffect(() => {
    if (!sliderState.clickedButton) return;
    const goodBlockWidth = 326;
    setPosition(
      sliderState.clickedButton === 'nextButton' ? position - goodBlockWidth : position + goodBlockWidth,
    );
    const currentPosition =
      sliderState.clickedButton === 'nextButton' ? position - goodBlockWidth : position + goodBlockWidth;

    sliderState.list.style.transform = `translateX(${currentPosition}px)`;
    sliderState.list.style.transition = '0.2s ease-out';
  }, [sliderState]);

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
