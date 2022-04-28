import {SideDishContentsList} from 'components';
// import './SideDishContents.css';
import {StyledSideDishContents} from './SideDishContents.styled';

function SideDishContents() {
  return (
    <StyledSideDishContents>
      <ul>
        <SideDishContentsList />
      </ul>
    </StyledSideDishContents>
  );
}

export {SideDishContents};
