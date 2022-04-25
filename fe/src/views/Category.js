import { categoryData } from '../helper/mock';
import { Card } from '../components/Card';
import { applyFlex } from '../helper/utils';
import styled from 'styled-components';
import { buttonIcons } from '../helper/constants';

export function Category() {
  return (
    <CategoryWrapper>
      <CategoryTitle>식탁을 풍성하게 하는 정갈한 밑반찬</CategoryTitle>
      <CategoryCardWrapper flex>
        <LeftButton>{buttonIcons.left}</LeftButton>
        {categoryData.map((product, idx) => {
          return <Card product={product} size="small" key={idx}></Card>;
        })}
        <RightButton>{buttonIcons.right}</RightButton>
      </CategoryCardWrapper>
    </CategoryWrapper>
  );
}

const CategoryWrapper = styled.div`
  position: absolute;
  margin-top: 56px;
`;

const CategoryTitle = styled.h3`
  font-size: 24px;
  line-height: 38px;
  padding: 0 80px;
`;

const CategoryCardWrapper = styled.div`
  margin-top: 40px;
  padding: 0 56px 0 80px;
  ${props => applyFlex(props)}
`;

const LeftButton = styled.div`
  position: absolute;
  left: 35px;
  top: 250px;

  path {
    stroke: #1b1b1b;
  }
`;

const RightButton = styled.div`
  position: absolute;
  right: 35px;
  top: 250px;

  path {
    stroke: #1b1b1b;
  }
`;
