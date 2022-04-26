import * as S from './Slide.style';

const SlidePagination = ({ currentPage, totalPage }) => {
  return (
    <S.Pagination>
      <S.CurrentPage>{currentPage}</S.CurrentPage>
      <span> / </span>
      <S.TotalPage>{totalPage}</S.TotalPage>
    </S.Pagination>
  );
};

export default SlidePagination;
