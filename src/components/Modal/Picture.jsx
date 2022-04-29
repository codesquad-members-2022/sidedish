import React from 'react';
import styled from 'styled-components';

function Picture({ image, alt }) {
  return (
    <Pictures>
      <img width="392px" height="392px" src={image} alt={alt} />
      <Thumbnails>
        <img width="72px" height="72px" src={image} alt={alt} />
        <img width="72px" height="72px" src={image} alt={alt} />
      </Thumbnails>
    </Pictures>
  );
}

const Pictures = styled.div({
  display: 'flex',
  flexDirection: 'column',
  marginRight: '32px'
});

const Thumbnails = styled.div({
  display: 'flex',
  gap: '8px',
  marginTop: '8px'
});

export default Picture;
