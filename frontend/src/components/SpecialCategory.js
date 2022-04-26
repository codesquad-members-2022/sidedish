import styled from "styled-components";
import { useState } from "react";
import { CardList } from "./CardList";
import { SIZES } from "../convention";
import { useFetch } from "../fetcher";
import { custom_flex, custom_font } from "../styles/global";
import { HorizontalLine } from "./HorizontalLine";

const Wrapper = styled.div`
  margin: 56px 0px;
`;

const TitleWrapper = styled.div`
  ${custom_flex("row", "center")}
`;

const TitleBadge = styled.div`
  ${custom_font("Noto Sans KR", 16, 500, 26)}
  border: 2px solid #1b1b1b;
  box-sizing: border-box;
  border-radius: 999px;
  background: #f8f7f7;
  margin-right: 16px;
  padding: 8px 16px; ;
`;

const Title = styled.div`
  font-weight: 700;
  font-size: 40px;
  line-height: 58px;
  letter-spacing: -0.004em;
`;

const TabBar = styled.ul`
  position: relative;
  margin-top: 24px;
  display: flex;
`;

const TabItem = styled.li`
  margin-right: 32px;
  padding-bottom: 17px;
  font-weight: 500;
  font-size: 20px;
  line-height: 30px;
  display: flex;
  align-items: center;
  text-align: center;
  letter-spacing: -0.008em;
  ${(props) => props.selected && `border-bottom: 2px solid black;`}
`;

export const SpecialCategory = ({ specialCategories }) => {
  const [selected, setSelected] = useState(specialCategories[0].id);
  const categoryData = useFetch(selected, true);

  return (
    <Wrapper>
      <TitleWrapper>
        <TitleBadge>기획전</TitleBadge>
        <Title>한 번 주문하면 두 번 반하는 반찬</Title>
      </TitleWrapper>
      <TabBar>
        {specialCategories.map((specialCategory) => (
          <TabItem
            key={specialCategory.id}
            selected={selected === specialCategory.id}
            onClick={() => setSelected(specialCategory.id)}
          >
            {specialCategory.name}
          </TabItem>
        ))}
        <HorizontalLine color={"Grey4"} />
      </TabBar>
      <CardList products={categoryData?.products} cardSize={SIZES.large}></CardList>
    </Wrapper>
  );
};
