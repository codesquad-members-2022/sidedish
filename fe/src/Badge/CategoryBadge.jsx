import styled from 'styled-components';

const Root = styled.button`
  padding: 8px 16px;
  border: 2px solid black;
  border-radius: 999px;
  background-color: #F8F7F7; // TODO: 변수로 바꾸기
`;

export const CategoryBadge = ({ name }) => {
  return <Root className={"fonts-md"}>{name}</Root>;
};
