import styled from 'styled-components';

const TitleWrapper = styled.ul`
  height: 20px;
  color: #1b1b1b;
  font-weight: 400;
  margin-right: 24px;
  cursor: pointer;
`;

const SubTitle = styled.li`
  padding: 8px 0;
  &:first-child {
    padding-top: 16px;
  }
`;

export default function HeaderCategory({ open, category }) {
  const categorySubList = category.sub.map((subCategory, index) => {
    return <SubTitle key={index}>{subCategory}</SubTitle>;
  });
  return (
    <TitleWrapper>
      {category.main}
      {open ? categorySubList : ''}
    </TitleWrapper>
  );
}
