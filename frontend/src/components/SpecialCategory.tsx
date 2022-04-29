import styled, { css } from "styled-components";
import { useState } from "react";
import { CardList } from "./CardList";
import { Queries } from "../convention";
import { useFetch } from "../fetcher";
import { custom_flex, custom_font } from "../styles/global";
import { HorizontalLine } from "./HorizontalLine";
import { SIZES, SpecialCategories } from "../types";

const Wrapper = styled.div`
  margin: 56px 0px;
`;

const TitleWrapper = styled.div`
  ${custom_flex("row", "center")}
`;

const TitleBadge = styled.div`
  ${custom_font("Noto Sans KR", 16, 500, 26)}
  background: ${({ theme }) => theme.colors.Off_White};
  border: 2px solid #1b1b1b;
  border-radius: 999px;
  box-sizing: border-box;
  margin-right: 16px;
  padding: 8px 16px; ;
`;

const Title = styled.div`
  ${custom_font("Noto Sans KR", 40, 700, 58, -0.004)}
`;

const TabBar = styled.ul`
  position: relative;
  margin-top: 24px;
  display: flex;
`;

const TabItem = styled.li<{ selected: boolean }>`
  margin-right: 32px;
  padding-bottom: 17px;
  ${custom_font("Noto Sans KR", 20, 500, 30, -0.008)}
  ${custom_flex("row", "center", "center")}
  ${(props) =>
    props.selected &&
    css`
      border-bottom: 2px solid black;
    `}
`;

export const SpecialCategory = ({ specialCategories }: SpecialCategories) => {
  const [selected, setSelected] = useState<number>(specialCategories[0].id);
  const { products } = useFetch(Queries.specialProducts, selected, selected);
  console.log(selected, products);
  return (
    <>
      {products && (
        <Wrapper data-cy="special">
          <TitleWrapper>
            <TitleBadge>기획전</TitleBadge>
            <Title>한 번 주문하면 두 번 반하는 반찬</Title>
          </TitleWrapper>
          <TabBar>
            {specialCategories.map((specialCategory) => (
              <TabItem
                data-cy="tabItem"
                key={specialCategory.id}
                selected={selected === specialCategory.id}
                onClick={() => setSelected(specialCategory.id)}
              >
                {specialCategory.name}
              </TabItem>
            ))}
            <HorizontalLine position={100} color={"Grey4"} />
          </TabBar>
          <CardList products={products} size={SIZES.large}></CardList>
        </Wrapper>
      )}
    </>
  );
};
