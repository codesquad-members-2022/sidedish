import styled from 'styled-components';

const TitleWrapper = styled.ul`
  height: 20px;
  margin-right: 24px;
  cursor: pointer;
  color: ${({ theme }) => theme.colors.black};
  font-weight: 400;
  line-height: 18px;
  font-size: 16px;
`;

const SubTitle = styled.li`
  padding: 8px 0;

  &:first-child {
    padding-top: 16px;
  }

  &:hover {
    text-decoration: underline;
  }
`;

export default function HeaderCategory({ open, category }) {
  const categorySubList = category.sub.map((subCategory, index) => {
    return <SubTitle key={index}>{subCategory}</SubTitle>;
  });
  return (
    <TitleWrapper>
      {category.main}
      {open && categorySubList}
    </TitleWrapper>
  );
}
