import * as S from './ProductDetailModal.style';

import { ICON_NAME } from '../../constants/productDetailModal';
import { ReactComponent as PlusIcon } from '../../asset/icons/plus.svg';
import { ReactComponent as MinusIcon } from '../../asset/icons/minus.svg';

const IconButton = ({ name, handleClick }) => {
  return <S.IconButton onClick={handleClick}>{_getIcon(name)}</S.IconButton>;
};

const _getIcon = name => {
  if (name === ICON_NAME.PLUS) return <PlusIcon />;
  if (name === ICON_NAME.MINUS) return <MinusIcon />;
};

export default IconButton;
