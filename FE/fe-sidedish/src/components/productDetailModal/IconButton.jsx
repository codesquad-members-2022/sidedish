import * as S from './ProductDetailModal.style';

import { ReactComponent as PlusIcon } from '../../asset/icons/plus.svg';
import { ReactComponent as MinusIcon } from '../../asset/icons/minus.svg';

const IconButton = ({ name, handleClick }) => {
  return <S.IconButton onClick={handleClick}>{_getIcon(name)}</S.IconButton>;
};

const _getIcon = name => {
  const PLUS = 'plus';
  const MINUS = 'minus';

  if (name === PLUS) return <PlusIcon />;
  if (name === MINUS) return <MinusIcon />;
};

export default IconButton;
