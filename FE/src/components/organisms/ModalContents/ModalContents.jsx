import MenuDetailSection from "@/components/organisms/MenuDetailSection/MenuDetailSection";
import "./ModalContents.scss";
import close from "@/assets/image/close.svg";

export default function ModalContents({ card, handleModalOff, handleModal }) {
  return (
    <div className="modal-content">
      <button
        className="modal-button__close"
        onClick={(e) => {
          e.stopPropagation();
          handleModalOff();
        }}
      >
        <img src={close} alt="close" />
      </button>
      <MenuDetailSection card={card} />
    </div>
  );
}
