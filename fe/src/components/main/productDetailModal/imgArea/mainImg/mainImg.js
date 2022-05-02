import { StyledImg } from './mainImg.styled';

export function MainImg({ urls, mainImgIdx }) {
  return <StyledImg src={urls[mainImgIdx]}></StyledImg>;
}
