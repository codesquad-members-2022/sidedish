import "./ArticleFigure.scss";

export function ArticleFigure({ src, alt, size, setIsHovered }) {
  return (
    <figure className="menu-article__figure">
      <img
        src={src}
        alt={alt}
        width={size}
        height={size}
        onMouseEnter={() => {
          setIsHovered(true);
        }}
        onMouseLeave={() => {
          setIsHovered(false);
        }}
      />
    </figure>
  );
}
