Git & GitHub Team Workflow

This README contains the most useful Git commands and the workflow our team should follow while working on the same project.

The goal is simple: avoid overwriting each other's work, keep the code updated, and maintain a clean project history.

1. Clone the Repository

When you are joining the project for the first time, clone the repository to your computer.

git clone <repository-url>
cd <project-folder>

git clone downloads the complete repository from GitHub to your system.

2. Check Your Current Branch

Before doing anything, check which branch you are currently on:

git branch

The branch with * is your current branch.

You can also use:

git status

git status shows your current branch and whether you have any modified or untracked files.

3. Get the Latest Code

Before starting new work, always make sure your local main is updated.

git switch main
git pull origin main

git pull downloads the latest changes from GitHub and updates your local branch.

Always do this before starting a new feature.

4. Create Your Own Branch

Never directly work on main for a new feature.

Create a separate branch:

git switch -c feature/<feature-name>

Example:

git switch -c feature/login

Other useful naming conventions:

feature/login
feature/navbar
fix/login-error
fix/database-connection
docs/api-documentation
refactor/user-service

A branch keeps your work separate from the stable main branch.

5. Work on Your Feature

Now make your changes normally.

After making changes, check what Git detected:

git status

To see exactly what changed:

git diff

git diff helps you review your changes before committing them.

6. Add Changes

To stage all modified files:

git add .

Or stage a specific file:

git add <filename>

Example:

git add src/components/Navbar.jsx

git add tells Git which changes you want to include in your next commit.

7. Commit Your Changes

Create a commit after completing a meaningful piece of work:

git commit -m "feat: add login page"

A commit is basically a checkpoint of your project.

Recommended commit format

feat: add login page
fix: resolve login validation bug
docs: update installation guide
refactor: simplify authentication logic
style: improve navbar spacing
test: add login tests

Try to keep commits small and meaningful instead of committing everything at the end.

8. Push Your Branch

Push your branch to GitHub:

git push -u origin <branch-name>

Example:

git push -u origin feature/login

After the first push, you can usually use:

git push

Now your branch and commits are available on GitHub.

9. Create a Pull Request

After pushing your feature:

Your Branch
     ↓
Push to GitHub
     ↓
Create Pull Request
     ↓
Code Review
     ↓
Approved
     ↓
Merge into main

A Pull Request (PR) means:

"I have completed my changes. Please review them before adding them to the main project."

Don't merge your own PR without following the team's review rules.

10. Update Your Branch with Latest main

While you are working, someone else may merge changes into main.

Before creating your PR, update your branch.

First:

git switch main
git pull origin main

Then return to your branch:

git switch feature/login

Merge the latest main into your branch:

git merge main

This helps you find conflicts before your PR is merged.

11. Merge Conflicts

A conflict happens when Git cannot automatically decide which version of a piece of code should be kept.

You may see something like:

<<<<<<< HEAD
your code
=======
other person's code
>>>>>>> main

Open the file and decide which code should remain.

After fixing the conflict:

git add .
git commit -m "fix: resolve merge conflict"

Then push:

git push

Don't blindly delete conflict markers. Understand the two changes and combine them correctly.

12. Stash — Temporarily Save Changes

Suppose you have unfinished work but need to switch branches.

Use:

git stash

Your uncommitted changes are temporarily stored.

Later, restore them:

git stash pop

Useful when you don't want to create a commit for unfinished work.

13. Undo Uncommitted Changes

To discard changes in a specific file:

git restore <filename>

Example:

git restore app.js

To discard all uncommitted changes:

git restore .

⚠️ Be careful: these changes may be permanently lost.

14. Undo a Commit Safely

If a commit has already been pushed/shared with the team, prefer:

git revert <commit-id>

git revert creates a new commit that reverses the previous commit.

Avoid using git reset on shared branches unless you know exactly what you are doing.

15. View Commit History

To see previous commits:

git log

A shorter version:

git log --oneline

Example:

a31f8c2 feat: add login page
b72cd91 fix: database connection
91ab321 docs: update README

16. See All Branches

Local branches:

git branch

Local + remote branches:

git branch -a

Switch to another branch:

git switch <branch-name>

17. Delete a Branch

After your feature has been merged, you can delete your local branch:

git branch -d feature/login

To delete a remote branch:

git push origin --delete feature/login

Only delete branches when you're sure they are no longer needed.

18. Useful Commands — Quick Reference

Command

Purpose

git status

Check current changes

git branch

See branches

git switch main

Switch to main

git switch -c feature/name

Create a new branch

git pull origin main

Get latest main

git add .

Stage changes

git commit -m "message"

Save a checkpoint

git push

Upload commits

git merge main

Merge main into current branch

git stash

Temporarily save changes

git stash pop

Restore stashed changes

git log --oneline

View commit history

git diff

See code changes

git restore file

Discard uncommitted file changes

git revert <id>

Safely undo a shared commit

19. Our Team Workflow

Every team member should generally follow this:

# 1. Update main
git switch main
git pull origin main

# 2. Create your feature branch
git switch -c feature/<feature-name>

# 3. Work on the project

# 4. Check changes
git status
git diff

# 5. Stage and commit
git add .
git commit -m "feat: describe your change"

# 6. Push
git push -u origin feature/<feature-name>

# 7. Create a Pull Request on GitHub

# 8. After review, merge the PR

# 9. Update your local main
git switch main
git pull origin main

20. Team Rules

🚫 Don't

Don't directly push to main.

Don't work on someone else's feature branch without coordination.

Don't commit .env files or passwords.

Don't commit node_modules/.

Don't use meaningless commit messages like update, changes, or final.

Don't ignore merge conflicts.

Don't force push to shared branches.

✅ Do

Pull the latest main before starting new work.

Create a separate branch for each feature/fix.

Make small, meaningful commits.

Write clear commit messages.

Review your own changes before creating a PR.

Pull/merge the latest changes before your PR is merged.

Communicate with the team when modifying shared files.

Keep main stable.

21. Important .gitignore

Make sure files such as these are not accidentally committed:

node_modules/
.env
.env.local
dist/
build/
*.log

Never upload secrets such as:

API keys
Database passwords
JWT secrets
AWS credentials
Private keys

⭐ The Golden Rule

Pull → Branch → Work → Commit → Push → Pull Request → Review → Merge

If everyone follows the same workflow, most common team Git problems can be avoide
