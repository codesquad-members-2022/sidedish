import styled from 'styled-components';
import { applyFlex } from '../../../helper/utils';
import { eventsNumber } from '../../../helper/constants';

export const StyledWrapper = styled.div`
  ${({ flex }) => applyFlex({ flex })}
  margin-top:16px;
  color: #fff;
  font-weight: 500;
  font-size: 12px;
`;

export const Event = styled.div`
  ${({ flex, justify, align }) => applyFlex({ flex, justify, align })}
  ${({ eventId }) => applyEventStyleByEventId(eventId)}
  margin-right: 8px;
  border-radius: 999px;
`;

function applyEventStyleByEventId(eventId) {
  if (eventsNumber[eventId] === '런칭특가') {
    return `
      width: 76px;
      height: 30px;
      background: #ff8e14;
    `;
  }
  if (eventsNumber[eventId] === '이벤트특가') {
    return `
      width: 87px;
      height: 30px;
      background: #6dd028;
    `;
  }
}
