import styled, { ThemeProvider } from "styled-components";
import theme from "../styles/theme.js";
import CardList from "./CardList.js";

const Header = styled.h3`
  font-size: ${({ theme }) => theme.fontSize.medium};
`;

const Category = ({ dish, category }) => {
  const title = {
    side: "식탁을 풍성하게 하는 정갈한 밑반찬",
    soup: "정성이 담긴 뜨끈뜨끈 국물 요리",
    main: "모두가 좋아하는 든든한 메인 요리",
  };
  console.log(dish);
  return (
    <ThemeProvider theme={theme}>
      <Header>{title[category]}</Header>
      <CardList
        key={category}
        cards={dish}
        tabNumber={1}
        index={1}
        cardSize={"medium"}
      ></CardList>
    </ThemeProvider>
  );
};

export default Category;
