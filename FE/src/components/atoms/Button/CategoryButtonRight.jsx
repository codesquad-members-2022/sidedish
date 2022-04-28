import "./CategoryButtonRight.scss";

export function CategoryButtonRight({ pageIndex, setPageIndex, maxIndex }) {
  return (
    <button
      className="category-button__right"
      onClick={(event) => {
        event.preventDefault();
        if (pageIndex < maxIndex) setPageIndex(pageIndex + 1);
      }}
    ></button>
  );
}
