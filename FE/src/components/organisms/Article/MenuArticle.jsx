import { useState } from "react";
import { MenuDescription } from "@/components/molecules/Description/MenuDescription";
import { MenuLabel } from "@/components/atoms/Label/MenuLabel";
import { DeliveryLabel } from "@/components/atoms/Label/DeliveryLabel";
import "./MenuArticle.scss";
import { ArticleFigure } from "@/components/atoms/Figure/ArticleFigure";
import ModalPortal from "../../../Portal";
import Modal from "../../templates/Modal/Modal";

export function MenuArticle({ card, index, size }) {
  const [isHovered, setIsHovered] = useState(false);
  const [modalOn, setModalOn] = useState(false);
  console.log(modalOn);
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
      onClick={(e) => {
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
        deliveryID={card.delivery_id}
        isHovered={isHovered}
        setIsHovered={setIsHovered}
      />
      <ArticleFigure
        className="menu-article__figure"
        src={card.main_image}
        alt="menu-image"
        size={size}
        setIsHovered={setIsHovered}
      />
      <MenuDescription card={card} />
      <MenuLabel labelID={card.label_id} />
    </article>
  );
}
