#!/bin/bash

REPO_DIR="/home/basti/prg/JavaDAW"

cd "$REPO_DIR" || exit 1

DATE=$(date +"%Y-%m-%d %H:%M")

git add .

# evita commits vacíos
if git diff --cached --quiet; then
  echo "No changes to commit"
  exit 0
fi

git commit -m "ci: automated commit [$DATE]"
git push
