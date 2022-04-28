import React, { useState } from 'react';

import { CARD_SIZE } from '../../constants/card';

import exhibition from '../../data/exhibition';
import { dish10 } from "../../data/dishes";

import Exhibition from "../exhibition/Exhibition";
import Category from "../category/Category";
import AlertModal from '../modal/AlertModal';

const Main = () => {

  const [isAlertModalOpen, setIsAlertModalOpen] = useState(false);

  const openAlertModal = () => setIsAlertModalOpen(true);

  return (
    <>
      <Exhibition { ...exhibition } />
      <Category cardSize={CARD_SIZE.MEDIUM} {...dish10} />
      <button onClick={openAlertModal}>Open Alert Modal</button>
      {isAlertModalOpen && (
        <AlertModal
          alertContent={`오류가 발생했습니다.\n다시 주문해주세요.`}
          setIsAlertModalOpen={setIsAlertModalOpen}
        />
      )}
    </>
  );
};

export default Main;
