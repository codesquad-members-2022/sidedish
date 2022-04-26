export function FigureWithSize({ src, alt, size, className = null }) {
  return (
    <>
      {className ? (
        <figure className={className}>
          <img src={src} alt={alt} width={size} height={size} />
        </figure>
      ) : (
        <figure>
          <img src={src} alt={alt} width={size} height={size} />
        </figure>
      )}
    </>
  );
}
