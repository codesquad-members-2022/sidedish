import SubContent from './SubContent';

const SubContents = ({ subContents }) => (
  <>
    {subContents?.map((content, idx) => (
      <SubContent key={`${content.detailTitle}-${idx}`} content={content} />
    ))}
  </>
);
export default SubContents;
