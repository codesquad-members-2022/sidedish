import { StyledSvgWrapper } from './Header.styled';

export function Svg({ icons, useIconsName }) {
  return useIconsName.map((iconName, idx) => (
    <StyledSvgWrapper key={`${iconName}-${idx}`}>{icons[iconName]}</StyledSvgWrapper>
  ));
}
