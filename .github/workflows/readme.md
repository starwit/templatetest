# Workflow Description

* **buildpublish.yml (Build and Publish)** to test docker builds and pushes on your own branch.
* **createRelease.yml (Create release and tag)** 
    * use `prerelease` to check release creation or create a release for testing
    * use `major` or `minor` and execute script on main branch: to build additional major and minor release
    * (!) If you are executing patch or higher release on another branch than main, release numbering might get broken.
