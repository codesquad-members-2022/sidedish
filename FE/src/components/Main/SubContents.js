import SubContent from './SubContent';

const SubContents = ({ subContents }) => (
  <>
    {subContents.map((content, idx) => (
      <SubContent key={content.title + idx} content={content} />
    ))}
  </>
);
export default SubContents;
