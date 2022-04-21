import styled from 'styled-components';

import { FONT } from '../../constants/fonts';
// import subContents from '../../mocks/subContents';
import Text from '../Text';
import FoodCards from './FoodCards';

const SubTitle = styled.div`
  margin: 0 80px;
`;

const createSubContent = (content, idx) => (
  <div key={content + idx}>
    <SubTitle>
      <Text font={FONT.XLARGE_BOLD}>{content.title}</Text>
    </SubTitle>
    <FoodCards foods={content.foods} />
  </div>
);
const SubContents = ({ subContents }) => <div>{subContents.map(createSubContent)}</div>;
export default SubContents;
