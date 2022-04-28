import { buttonIcons } from '../../../../helper/constants';
import { Btn, Header, HeaderContent, Main, RecommendContainer, SliderArea, Title } from './recommend.styled';

export function RecommendArea() {
  return (
    <RecommendContainer>
      <Header flex justify="space-between">
        <Title>함께하면 더욱 맛있는 상품</Title>
        <SliderArea flex align="center">
          <Btn>{buttonIcons.left}</Btn>
          <HeaderContent>1 / 2</HeaderContent>
          <Btn>{buttonIcons.right}</Btn>
        </SliderArea>
      </Header>
      <Main></Main>
    </RecommendContainer>
  );
}
