import styled from 'styled-components';

const SpecialContainer = styled.div`
  width: 100%;
`;

const SpecialHeader = styled.div`
  padding: 56px 80px 0 80px;
  border-bottom: 1px solid ${props => props.theme.colors.grey4};
`;

const SpecialTitleBox = styled.div`
  display: flex;
  margin-bottom: 24px;
`;

const SpecialBadge = styled.div`
  width: 76px;
  height: 42px;
  border: 2px solid ${props => props.theme.colors.black};
  border-radius: 20px;
  line-height: 42px;
  text-align: center;
  margin-right: 16px;
`;

const SpecialTitle = styled.h1`
  font-size: ${props => props.theme.fontSize.display};
  font-weight: ${props => props.theme.fontWeight.display};
  color: ${props => props.theme.colors.black};
`;

const SpecialTabBar = styled.div`
  display: flex;
  width: 100%;
`;

const SpecialTab = styled.div`
  font-size: ${props => props.theme.fontSize.large};
  font-weight: ${props => props.theme.fontWeight.bold};
  color: ${props => props.theme.colors.black};
  margin-right: 32px;
  padding-bottom: 17px;
  box-shadow: 0 ${({ isSelected }) => (isSelected ? '1px' : '0')} ${props => props.theme.colors.black};
  cursor: pointer;
`;

const CardContainer = styled.div`
  display: flex;
  justify-content: space-between;
  padding: 34px 80px 56px 80px;
  border-bottom: 1px solid ${props => props.theme.colors.grey4};
`;

export {
  SpecialContainer,
  SpecialHeader,
  SpecialTitleBox,
  SpecialBadge,
  SpecialTitle,
  SpecialTabBar,
  SpecialTab,
  CardContainer,
};
