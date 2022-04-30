import { useState } from 'react';
import styled, { css } from 'styled-components';
import { SERVER_URL } from 'constant.js';
import RecommendTabList from 'Main/Recommend/RecommendTabList';
import { useFetch } from 'useFetch';
import Loading from 'common/Loading';
import ErrorComponent from 'common/Error';

const RecommendTabCategory = styled.ul`
  ${({ theme }) => theme.flexLayout.default};
`;

const RecommendTabCategoryItem = styled.li`
  margin-right: 32px;
  padding-bottom: 17px;
  text-align: center;
  cursor: pointer;
  ${(props) =>
    props.focus === props.id &&
    css`
      border-bottom: 2px solid #1b1b1b;
    `}
  ${({ theme }) => theme.fontStyles.largeBold};
`;

const RecommendTab = () => {
  const [focus, setFocus] = useState(1);
  const [dishes, isLoading, isError] = useFetch(`${SERVER_URL}events/special/`);

  const onClick = (e) => {
    const id = e.currentTarget.id;
    setFocus(Number(id));
  };

  if (isError) {
    return <ErrorComponent />;
  }

  if (isLoading) {
    return <Loading />;
  }

  return (
    dishes.length !== 0 && (
      <>
        <RecommendTabCategory>
          {dishes.eventDishes.map((item) => {
            return (
              <RecommendTabCategoryItem key={item.id} id={item.id} onClick={onClick} focus={focus}>
                <p>{item.name}</p>
              </RecommendTabCategoryItem>
            );
          })}
        </RecommendTabCategory>
        <RecommendTabList
          items={dishes.eventDishes.find((obj) => obj.id === focus)}
        ></RecommendTabList>
      </>
    )
  );
};

export default RecommendTab;
