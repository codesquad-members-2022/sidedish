import { useState, useCallback, useEffect } from 'react';
import styled, { css } from 'styled-components';
import axios from 'axios';
import { SERVER_URL } from 'constant.js';
import RecommendTabList from 'Main/Recommend/RecommendTabList';

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
  const [dishes, setDishes] = useState([]);

  const fetchData = useCallback(async () => {
    try {
      const { data } = await axios.get(`${SERVER_URL}special/`);
      if (data) {
        setDishes(data.eventDishes);
      }
    } catch (error) {
      throw new Error(error);
    }
  }, []);

  useEffect(() => {
    fetchData();
  }, [fetchData]);

  const onClick = (e) => {
    const id = e.currentTarget.id;
    setFocus(Number(id));
  };
  const tabCategoryList = dishes.map((item) => {
    return (
      <RecommendTabCategoryItem key={item.id} id={item.id} onClick={onClick} focus={focus}>
        <p>{item.name}</p>
      </RecommendTabCategoryItem>
    );
  });

  return (
    <>
      <RecommendTabCategory>{tabCategoryList}</RecommendTabCategory>
      {dishes.length !== 0 ? (
        <RecommendTabList items={dishes.find((obj) => obj.id === focus)}></RecommendTabList>
      ) : (
        []
      )}
    </>
  );
};

export default RecommendTab;
