import styled from 'styled-components';
import { ReactComponent as Delivery } from 'assets/delivery.svg';

const thumbnailSize = {
  xLarge: '411px',
  large: '392px',
  medium: '302px',
  small: '160px',
  xSmall: '72px',
};

const ThumbnailStyle = styled.div.attrs(props => ({ type: props.src }))`
  width: ${({ size }) => (size ? thumbnailSize[size] : thumbnailSize.xLarge)};
  height: ${({ size }) => (size ? thumbnailSize[size] : thumbnailSize.xLarge)};
  background-image: url(${({ src }) => src});
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;

  :hover {
    filter: brightness(90%);
  }
`;

const DeliveryIcon = styled(Delivery)`
  position: absolute;
  right: 20px;
  top: 20px;
`;

export { ThumbnailStyle, DeliveryIcon };
