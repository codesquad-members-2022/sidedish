import styled from "styled-components";
import theme from "../styles/theme.js";
import Slider from "./Slider.js";

const TITLE = {
  SIDE: "식탁을 풍성하게 하는 정갈한 밑반찬",
  SOUP: "정성이 담긴 뜨끈뜨끈 국물 요리",
  MAIN: "모두가 좋아하는 든든한 메인 요리",
};

const Category = ({ dish, category, display }) => {
  return (
    <>
      <Wrapper display={display}>
        <Header>{TITLE[category]}</Header>
        <Slider
          data={dish}
          key={category}
          cardSize={theme.cardSize.medium}
          numOfCards={4}
          gap={theme.cardSize.gap}
        />
      </Wrapper>
    </>
  );
};

const Wrapper = styled.div`
  position: relative;
  margin: 0 auto;
  max-width: 144rem;
`;

const Header = styled.h3`
  box-sizing: border-box;
  padding: 5.6rem 8rem 0;
  font-size: ${({ theme }) => theme.fontSize.xLarge};
`;

export default Category;
