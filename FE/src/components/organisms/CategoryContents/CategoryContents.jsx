import { imageSize } from "@/constant/constant";
import { useState } from "react";
import { CategoryButtonLeft } from "@/components/atoms/Button/CategoryButtonLeft";
import { CategoryButtonRight } from "@/components/atoms/Button/CategoryButtonRight";
import { CategorySlideSection } from "../CategorySlideSection/CategorySlideSection";

export function CategoryContents({ dataName, dataID }) {
  const [pageIndex, setPageIndex] = useState(null);
  const [maxIndex, setMaxIndex] = useState(null);

  return (
    <>
      <CategoryButtonLeft pageIndex={pageIndex} setPageIndex={setPageIndex} />
      <CategoryButtonRight
        pageIndex={pageIndex}
        setPageIndex={setPageIndex}
        maxIndex={maxIndex}
      />
      <CategorySlideSection
        dataName={dataName}
        dataID={dataID}
        size={imageSize.category}
        pageIndex={pageIndex}
        setPageIndex={setPageIndex}
        setMaxIndex={setMaxIndex}
      />
    </>
  );
}
