import { CategoryTitle } from "@/components/atoms/P/CategoryTitle.jsx";
import { CategoryContents } from "@/components/organisms/CategoryContents/CategoryContents";

export function CategorySection({ title, dataName, dataID }) {
  return (
    <section>
      <CategoryTitle title={title} />
      <CategoryContents dataName={dataName} dataID={dataID} />
    </section>
  );
}
