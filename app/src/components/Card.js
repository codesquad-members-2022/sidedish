/* eslint-disable prettier/prettier */
import { useContext } from "react";
import styled from "styled-components";
import { Badge } from "../styles/utils.js";
import { ModalContext } from "../contexts/ModalContext.js";

const Wrapper = styled.div`
  position: relative;
  cursor: pointer;
`;

const Badges = styled.div`
  margin-top: 2.2rem;
`;

const Image = styled.img`
  display: block;
  width: ${({ size }) => size};
`;

const Info = styled.div`
  margin-top: 1.6rem;
`;

const Title = styled.strong`
  font-size: ${({ theme }) => theme.fontSize.medium};
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  color: ${({ theme }) => theme.color.grey1};
`;

const Desc = styled.p`
  margin: 0.8rem 0;
  font-size: ${({ theme }) => theme.fontSize.small};
  font-weight: ${({ theme }) => theme.fontWeight.regular};
  color: ${({ theme }) => theme.color.grey2};
`;

const SPrice = styled.span`
  margin-right: 0.8rem;
  font-size: ${({ theme }) => theme.fontSize.medium};
  font-weight: ${({ theme }) => theme.fontWeight.bold};
`;

const NPrice = styled.span`
  font-size: ${({ theme }) => theme.fontSize.small};
  font-weight: ${({ theme }) => theme.fontWeight.regular};
  color: ${({ theme }) => theme.color.grey3};
  text-decoration: line-through;
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

const Card = ({ card, cardSize }) => {
  const { image, alt, delivery_type, title, description, s_price, n_price, badge } = card;
  const modal = useContext(ModalContext);

  const handleCardClick = () => {
    modal.setShowModal(!modal.showModal);
    modal.setProductHash(card.detail_hash);
  };

  return (
    <>
      <Wrapper onClick={handleCardClick}>
        <Thumbnail
          src={image}
          alt={alt}
          cardSize={cardSize}
          deliveryType={delivery_type}
        />
        <Info>
          <Title>{title}</Title>
          <Desc>{description}</Desc>
          <div>
            <SPrice>{s_price}</SPrice>
            <NPrice>{n_price}</NPrice>
          </div>
          <Badges>
            {badge && badge
              .filter(badge => badge !== '메인특가')
              .map(badge =>
                badge === '런칭특가' ? (
                  <Badge key={'lauching'} bgColor={'orange'}>
                    {badge}
                  </Badge>
                ) : (
                  <Badge key={'event'} bgColor={'green'}>
                    {badge}
                  </Badge>
                ),
              )
            }
          </Badges>
        </Info>
      </Wrapper>
    </>
  );
};

export default Card;
