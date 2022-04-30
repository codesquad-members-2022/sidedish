import { useContext } from "react";
import styled from "styled-components";
import { Badge, Wrapper } from "../styled-components/utils.js";
import { ModalContext } from "../contexts/ModalContext.js";
import Thumbnail from "./Thumbnail.jsx";

const Card = ({ card, cardSize }) => {
  const {
    image,
    alt,
    delivery_type,
    title,
    description,
    s_price,
    n_price,
    badge,
  } = card;
  const modal = useContext(ModalContext);

  const hideScrollbar = () => {
    document.body.style.overflow = "hidden";
  };

  const handleClickCard = () => {
    modal.setShowModal(!modal.showModal);
    modal.setProductHash(card.detail_hash);
    hideScrollbar();
  };

  return (
    <>
      <Wrapper onClick={handleClickCard}>
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
            {badge &&
              badge
                .filter((badge) => badge !== "메인특가")
                .map((badge) =>
                  badge === "런칭특가" ? (
                    <Badge key={"lauching"} bgColor={"orange"}>
                      {badge}
                    </Badge>
                  ) : (
                    <Badge key={"event"} bgColor={"green"}>
                      {badge}
                    </Badge>
                  )
                )}
          </Badges>
        </Info>
      </Wrapper>
    </>
  );
};

const Badges = styled.div`
  margin-top: 2.2rem;
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

export default Card;
