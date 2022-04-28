import { useState } from 'react';

import * as S from './Exhibition.style';

import ExhibitionTitle from './ExhibitionTitle';
import ExhibitionMenus from './ExhibitionMenus';
import TapButton from './TabButton';

const BADGE_EXHIBITION = '기획전';

const Exhibition = ({
  exhibitionTitle,
  categoryNameList,
  specialCategories: { categoryId, subCategoryList },
}) => {
  const [activeTapId, setActiveTapId] = useState(categoryId);
  const [menus, setMenus] = useState(subCategoryList);

  const handleTapClick = id => {
    if (activeTapId === id) return;
    setActiveTapId(id);
    setMenus(subCategoryList); // menus데이터를 fetch해서 받아와야함
  };

  return (
    <S.Container>
      <ExhibitionTitle badge={BADGE_EXHIBITION} title={exhibitionTitle} />
      <S.TapBarList>
        {categoryNameList.map(({ id, title }) => (
          <li key={id} onClick={() => handleTapClick(id)}>
            <TapButton isActive={activeTapId === id} title={title} />
          </li>
        ))}
      </S.TapBarList>
      <S.HorizontalLine />
      <ExhibitionMenus menus={menus} />
      <S.HorizontalLine />
    </S.Container>
  );
};

export default Exhibition;
