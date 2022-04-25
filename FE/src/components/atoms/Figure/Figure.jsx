export function Figure({ src, alt, className = null }) {
  return (
    <>
      {className ? (
        <figure className={className}>
          <img src={src} alt={alt} />
        </figure>
      ) : (
        <figure>
          <img src={src} alt={alt} />
        </figure>
      )}
    </>
  );
}
