import styled from 'styled-components';

const CardDelivery = styled.div`
  position: absolute;
  top: 20px;
  right: 20px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 142px;
  height: 142px;
  border: 1px solid ${({ theme }) => theme.colors.black};
  border-radius: 50%;
  background: #f8f7f7cc;
  opacity: ${(props) => (props.hover ? '1.0' : '0.0')};
  transition: all 0.25s ease-in;
`;

const Divider = styled.div`
  width: 63px;
  height: 1px;
  margin: 8px 0;
  background: ${({ theme }) => theme.colors.black};
`;

const DeliveryText = styled.span`
  ${({ theme }) => theme.fontStyles.mediumBold};
`;

export default function CardDeliveryInfo({ infos, hover }) {
  const [firstInfo, secondInfo] = infos.split(', ');
  return (
    <CardDelivery hover={hover}>
      <DeliveryText>{firstInfo}</DeliveryText>
      {secondInfo && <Divider />}
      <DeliveryText>{secondInfo}</DeliveryText>
    </CardDelivery>
  );
}
