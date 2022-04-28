import React from 'react';
import styled from 'styled-components';

function Picture() {
  return (
    <Pictures>
      <img
        width="392px"
        height="392px"
        src="http://public.codesquad.kr/jk/storeapp/data/main/739_ZIP_P__T.jpg"
        alt=""
      />
      <Thumbnails>
        <img
          width="72px"
          height="72px"
          src="http://public.codesquad.kr/jk/storeapp/data/main/739_ZIP_P__T.jpg"
          alt=""
        />
        <img
          width="72px"
          height="72px"
          src="http://public.codesquad.kr/jk/storeapp/data/main/739_ZIP_P__T.jpg"
          alt=""
        />
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
