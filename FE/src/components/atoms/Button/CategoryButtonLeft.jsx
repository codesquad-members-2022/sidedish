import "./CategoryButtonLeft.scss";

export function CategoryButtonLeft({ pageIndex, setPageIndex }) {
  return (
    <button
      className="category-button__left"
      onClick={(event) => {
        event.preventDefault();
        if (pageIndex > 0) setPageIndex(pageIndex - 1);
      }}
    ></button>
  );
}
