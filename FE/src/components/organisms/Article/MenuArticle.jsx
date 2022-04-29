import { useState } from "react";
import { MenuDescription } from "@/components/molecules/Description/MenuDescription";
import { MenuLabel } from "@/components/atoms/Label/MenuLabel";
import { DeliveryLabel } from "@/components/atoms/Label/DeliveryLabel";
import "./MenuArticle.scss";
import { ArticleFigure } from "@/components/atoms/Figure/ArticleFigure";
import ModalPortal from "@/Portal";
import Modal from "@/components/templates/Modal/Modal";

export function MenuArticle({ card, index, size }) {
  const [isHovered, setIsHovered] = useState(false);
  const [modalOn, setModalOn] = useState(false);
  const handleModal = () => {
    setModalOn(!modalOn);
  };

  const handleModalOn = () => {
    setModalOn(true);
  };
  const handleModalOff = () => {
    setModalOn(false);
  };

  return (
    <article
      className="menu-article"
      key={`article${index}`}
      onClick={() => {
        handleModalOn();
        setIsHovered(false);
      }}
    >
      <ModalPortal>
        {modalOn && (
          <Modal
            handleModalOff={handleModalOff}
            handleModal={handleModal}
            card={card}
          />
        )}
      </ModalPortal>
      <DeliveryLabel
        className="menu-article__delivery"
        deliveryID={card.deliveryId}
        isHovered={isHovered}
        setIsHovered={setIsHovered}
      />
      <ArticleFigure
        className="menu-article__figure"
        src={card.mainImage}
        alt="menu-image"
        size={size}
        setIsHovered={setIsHovered}
      />
      <MenuDescription card={card} />
      <MenuLabel labelID={card.labelId} />
    </article>
  );
}
