import styled from 'styled-components';

import MainContent from './MainContent';
import MoreContentButton from './MoreContentButton';
import SubContent from './SubContent';

const MainWrap = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 200px;
`;

const Main = () => (
  <MainWrap>
    <MainContent />
    <SubContent />
    <MoreContentButton />
  </MainWrap>
);

export default Main;
