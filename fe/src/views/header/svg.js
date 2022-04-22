import { StyledSvgWrapper } from './Header.styled';

export function Svg({ icons, useIconsName }) {
  return useIconsName.map((iconName, idx) => <StyledSvgWrapper key={idx}>{icons[iconName]}</StyledSvgWrapper>);
}
