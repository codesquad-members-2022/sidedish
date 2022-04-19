import styled from 'styled-components';

const TitleWrapper = styled.ul`
  color: #1b1b1b;
  font-weight: 400;
  margin: 0 24px 16px 0;
  cursor: pointer;
`;

const SubTitle = styled.li`
  margin: 8px 0;
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
