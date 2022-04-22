import { TitleWrapper, Title, Badge } from "./Exhibition.style";

const ExhibitionTitle = ({ badge, title }) => {
  return (
    <TitleWrapper>
      <Badge>{badge}</Badge>
      <Title>{title}</Title>
    </TitleWrapper>
  );
};

export default ExhibitionTitle;
