export function HeaderMainCategory({
  className,
  mainCategory,
  subCategories = null,
}) {
  return (
    <li className={className}>
      <span>{mainCategory}</span>
      {subCategories && <ul>{subCategories}</ul>}
    </li>
  );
}
