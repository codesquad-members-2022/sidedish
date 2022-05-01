import React, { useState } from 'react';
import { ThumbnailStyle, DeliveryIcon } from './Thumbnail.style';

const Thumbnail = ({ src, size, mouseEvent = true, onClick }) => {
  const [isMouseEnter, setIsMouseEnter] = useState(false);

  const handleThumbnailMouseEnter = () => {
    if (!mouseEvent) return;
    setIsMouseEnter(true);
  };

  const handleThumbnailMouseLeave = () => {
    if (!mouseEvent) return;
    setIsMouseEnter(false);
  };

  return (
    <ThumbnailStyle
      src={src}
      size={size}
      onMouseEnter={handleThumbnailMouseEnter}
      onMouseLeave={handleThumbnailMouseLeave}
      onClick={onClick}
    >
      {isMouseEnter && <DeliveryIcon />}
    </ThumbnailStyle>
  );
};

export default Thumbnail;
