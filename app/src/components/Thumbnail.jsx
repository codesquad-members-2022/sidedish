import styled from "styled-components";
import { Wrapper } from "../styled-components/utils.js";

const Thumbnail = ({ src, alt, cardSize, deliveryType }) => {
  return (
    <Wrapper>
      <Image size={cardSize} src={src} alt={alt} />
      <DimmedLayer>
        <Dimmer size={cardSize}></Dimmer>
        <HoverInfo>
          <div className="info">{deliveryType[0]}</div>
          <hr className="line"></hr>
          <div className="info">{deliveryType[1]}</div>
        </HoverInfo>
      </DimmedLayer>
    </Wrapper>
  );
};

const Image = styled.img`
  display: block;
  width: ${({ size }) => size};
`;

const DimmedLayer = styled.div`
  opacity: 0;

  &:hover {
    opacity: 1;
  }
`;

const Dimmer = styled.div`
  box-sizing: border-box;
  position: absolute;
  top: 0;
  width: ${({ size }) => size};
  height: ${({ size }) => size};
  background: ${({ theme }) => theme.color.black};
  opacity: 0.1;
`;

const HoverInfo = styled.div`
  box-sizing: border-box;
  position: absolute;
  padding-top: 4rem;
  top: 2rem;
  right: 2rem;
  width: 14.2rem;
  height: 14.2rem;
  background: rgba(248, 247, 247, 0.8);
  border: 1px solid ${({ theme }) => theme.color.black};
  border-radius: 50%;
  text-align: center;

  .info {
    font-size: ${({ theme }) => theme.fontSize.medium};
    line-height: 2.6rem;
  }

  .line {
    width: 6.2rem;
    margin: 0.8rem auto;
  }
`;

export default Thumbnail;
